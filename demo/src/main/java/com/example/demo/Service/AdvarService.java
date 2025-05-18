////package com.example.demo.Service;
////
////import com.example.demo.Dao.jpaAdvertisement;
////import com.example.demo.Entity.Advertisement;
////import com.example.demo.Entity.Package1;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.stereotype.Service;
////import org.yaml.snakeyaml.tokens.Token;
////import java.time.LocalDate;
////import java.time.Duration;
////import java.util.ArrayList;
////
////@Service
////public class AdvarService implements IAdverService {
////    jpaAdvertisement _jpa;
////    IClientServic clientServic; // הוספה
////
////    @Autowired
////    public AdvarService(jpaAdvertisement jpa, IClientServic clientServic) {
////        this._jpa = jpa;
////        this.clientServic = clientServic;
////    }
////
////    public Advertisement get(int place) {
////        ArrayList<Advertisement> a = (ArrayList<Advertisement>) _jpa.findAll();
////        for (Advertisement ad : a) {
////            if (ad.getNumPlace() == place)
////                System.out.println("i in get"+ad.toString());
////                if (!update(ad.getId())){
////                    System.out.println("i give you"+ad);
////                    return ad;
////                }
////                else {
////                    System.out.println("i dont update");
////                }
////
////        }
////        return null;
////    }
////
////    public void add(Advertisement a) {
////        System.out.println("i come");
////        Advertisement savedAd = _jpa.save(a);
////
////        clientServic.updateClientWithAdvertisement(savedAd.getClient().getEmail(), savedAd.getId());
////    }
////
////    public boolean update(int id) {
////        System.out.println("i come");
////        Advertisement newA = _jpa.findById(id).orElse(null);
////        if (newA != null) {
////            System.out.println("i dont null");
////            if (newA.getPackage1().getEnteries() == newA.getNumEnteries()) {
////                System.out.println("i dont good1 the packeg:"+newA.getPackage1().getEnteries()+"the aad"+newA.getNumEnteries());
////                newA.setActive(false);
////                _jpa.save(newA);
////                return true;
////            } else if (newA.getPackage1().getDays() < LocalDate.now().toEpochDay() - newA.getTime().toEpochDay()) {
////                System.out.println("i dont good2");
////                newA.setActive(false);
////                _jpa.save(newA);
////                return true;
////            } else {
////                System.out.println("i good");
////                newA.setNumEnteries(newA.getNumEnteries() + 1);
////                _jpa.save(newA);
////                return false;
////            }
////        }
////        return true;
////    }
////
////}
//
////
////package com.example.demo.Service;
////
////import com.example.demo.Dao.jpaAdvertisement;
////import com.example.demo.Entity.Advertisement;
////import com.example.demo.Entity.Package1;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.time.LocalDate;
////import java.time.Duration;
////import java.util.ArrayList;
////
////@Service
////public class AdvarService implements IAdverService {
////
////    private final jpaAdvertisement _jpa;
////    private final IClientServic clientServic;
////
////    @Autowired
////    public AdvarService(jpaAdvertisement jpa, IClientServic clientServic) {
////        this._jpa = jpa;
////        this.clientServic = clientServic;
////    }
////
////    public Advertisement get(int place) {
////        ArrayList<Advertisement> ads = (ArrayList<Advertisement>) _jpa.findAll();
////        for (Advertisement ad : ads) {
////            if (ad.getNumPlace() == place) {
////                System.out.println("Found advertisement: " + ad);
////                if (!update(ad.getId())) {
////                    return ad;
////                }
////            }
////        }
////        return null;
////    }
////
////    public void add(Advertisement a) {
////        if (a.getClient() == null || a.getPackage1() == null) {
////            throw new IllegalArgumentException("Client or Package cannot be null");
////        }
////        Advertisement savedAd = _jpa.save(a);
////        clientServic.updateClientWithAdvertisement(savedAd.getClient().getEmail(), savedAd.getId());
////    }
////
////    public boolean update(int id) {
////        Advertisement ad = _jpa.findById(id).orElse(null);
////        if (ad != null) {
////            // אם מספר הכניסות עבר את מספר ההכנסות המותר, או אם הזמן פג
////            if (ad.getPackage1().getEnteries() == ad.getNumEnteries() || ad.getPackage1().getDays() < Duration.between(ad.getTime().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()) {
////                ad.setActive(false);
////                _jpa.save(ad);
////                return true; // עדכון הושלם והמודעה לא פעילה
////            } else {
////                ad.setNumEnteries(ad.getNumEnteries() + 1); // עדכון מספר הכניסות
////                _jpa.save(ad);
////                return false; // המודעה נשארת פעילה
////            }
////        }
////        return true; // אם לא מצאנו את המודעה
////    }
////}
//
//import com.example.demo.Dao.jpaAdvertisement;
//import com.example.demo.Entity.Advertisement;
//import com.example.demo.Service.IAdverService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//
//public class AdvarService implements IAdverService {
//    @Autowired
//    private final jpaAdvertisement package1Repository;
//       private final IClientServic clientServic;
//
//    @Autowired
//    public AdvarService(jpaAdvertisement jpa, IClientServic clientServic) {
//        this._jpa = jpa;
//        this.clientServic = clientServic;
//    }
//    @Autowired
//    private jpa package1Repository;
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    // פונקציה להמיר את ה-DTO לישות Advertisement
//    public Advertisement add(AdvDto advDto) {
//        // חיפוש החבילה לפי ה-Id שהתקבל ב-DTO
//        Package1 package1 = package1Repository.findById(advDto.getPackageId())
//                .orElseThrow(() -> new RuntimeException("Package not found"));
//
//        // חיפוש הלקוח לפי המייל שהתקבל ב-DTO
//        Client client = clientRepository.findByEmail(advDto.getClientEmail())
//                .orElseThrow(() -> new RuntimeException("Client not found"));
//
//        // יצירת פרסומת מתוך ה-DTO, עם חיבור לחבילה וללקוח
//        Advertisement advertisement = new Advertisement();
//        advertisement.setImage(advDto.getImage());
//        advertisement.setNumPlace(advDto.getNumPlace());
//        advertisement.setClient(client);  // קישור ללקוח
//        advertisement.setPackage1(package1);  // קישור לחבילה
//        advertisement.setIsActive(true);
//        advertisement.setNumEnteries(0);
//
//        return advertisement;
//    }
//    public boolean update(int id) {
//        Advertisement ad = _jpa.findById(id).orElse(null);
//        if (ad != null) {
//            // אם מספר הכניסות עבר את מספר ההכנסות המותר, או אם הזמן פג
//            if (ad.getPackage1().getEnteries() == ad.getNumEnteries() || ad.getPackage1().getDays() < Duration.between(ad.getTime().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()) {
//                ad.setActive(false);
//                _jpa.save(ad);
//                return true; // עדכון הושלם והמודעה לא פעילה
//            } else {
//                ad.setNumEnteries(ad.getNumEnteries() + 1); // עדכון מספר הכניסות
//                _jpa.save(ad);
//                return false; // המודעה נשארת פעילה
//            }
//        }
//        return true; // אם לא מצאנו את המודעה
//    }
//    public Advertisement get(int place) {
//        ArrayList<Advertisement> ads = (ArrayList<Advertisement>) _jpa.findAll();
//        for (Advertisement ad : ads) {
//            if (ad.getNumPlace() == place) {
//                System.out.println("Found advertisement: " + ad);
//                if (!update(ad.getId())) {
//                    return ad;
//                }
//            }
//        }
//        return null;
//    }
//}

package com.example.demo.Service;

import com.example.demo.Dao.JpaClient;
import com.example.demo.Dao.jpaAdvertisement;
import com.example.demo.Dao.jpaPackage1;
import com.example.demo.Entity.AdvDto;
import com.example.demo.Entity.Advertisement;
import com.example.demo.Entity.Client;
import com.example.demo.Entity.Package1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class AdvarService implements IAdverService {

    private final jpaAdvertisement _jpa; // הגישה לפרסומות
    private final IClientServic clientServic; // שירות הלקוח
    private final jpaPackage1 package1Repository; // גישה לחבילות
//    private final JpaClient clientRepository; // גישה ללקוחות

    // אתחול
    @Autowired
    public AdvarService(jpaAdvertisement _jpa, IClientServic clientServic,
                        jpaPackage1 package1Repository) {
        this._jpa = _jpa;
        this.clientServic = clientServic;
        this.package1Repository = package1Repository;
    }

    // פונקציה להוסיף פרסומת מתוך DTO
    public Advertisement add(AdvDto advDto) {
        // חיפוש החבילה לפי ה-Id שהתקבל ב-DTO
        Package1 package1 = package1Repository.findById(advDto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        // חיפוש הלקוח לפי המייל שהתקבל ב-DTO
        Client client = clientServic.getById(advDto.getClientEmail());
//                .orElseThrow(() -> new RuntimeException("Client not found"));

        // יצירת פרסומת מתוך ה-DTO, עם חיבור לחבילה וללקוח
        Advertisement advertisement = new Advertisement();
        advertisement.setImage(advDto.getImage());
        advertisement.setNumPlace(advDto.getNumPlace());
        advertisement.setClient(client);  // קישור ללקוח
        advertisement.setPackage1(package1);  // קישור לחבילה
//       advertisement.setIsActive(true);
//        advertisement.setNumEnteries(0);

        // שמירת הפרסומת
        return _jpa.save(advertisement);
    }

    // פונקציה לעדכון פרסומת
    public boolean update(int id) {
        Advertisement ad = _jpa.findById(id).orElse(null);
        if (ad != null) {
            // אם מספר הכניסות עבר את מספר ההכנסות המותר, או אם הזמן פג
            if (ad.getPackage1().getEnteries() == ad.getNumEnteries() ||
                    ad.getPackage1().getDays() < Duration.between(ad.getTime().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()) {
                ad.setActive(false); // לכבות את המודעות שהגיעו לסיום
                _jpa.save(ad);
                return true; // עדכון הושלם והמודעה לא פעילה
            } else {
                ad.setNumEnteries(ad.getNumEnteries() + 1); // עדכון מספר הכניסות
                _jpa.save(ad);
                return false; // המודעה נשארת פעילה
            }
        }
        return true; // אם לא מצאנו את המודעה
    }

    // פונקציה לקבלת פרסומת לפי מיקום
    public Advertisement get(int place) {
        ArrayList<Advertisement> ads = (ArrayList<Advertisement>) _jpa.findAll();
        for (Advertisement ad : ads) {
            if (ad.getNumPlace() == place) {
                if (!update(ad.getId())) { // עדכון המודעה אם צריך
                    return ad;
                }
            }
        }
        return null; // לא נמצאה פרסומת מתאימה
    }
}

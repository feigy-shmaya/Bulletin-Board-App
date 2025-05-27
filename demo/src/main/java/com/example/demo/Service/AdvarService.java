package com.example.demo.Service;
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

    private final jpaAdvertisement _jpa;
    private final IClientServic clientServic;
    private final jpaPackage1 package1Repository;

    @Autowired
    public AdvarService(jpaAdvertisement _jpa, IClientServic clientServic,
                        jpaPackage1 package1Repository) {
        this._jpa = _jpa;
        this.clientServic = clientServic;
        this.package1Repository = package1Repository;
    }

    public Advertisement add(AdvDto advDto) {
        Package1 package1 = package1Repository.findById(advDto.getPackageId())
                .orElseThrow(() -> new RuntimeException("Package not found"));

        Client client = clientServic.getById(advDto.getClientEmail());

        Advertisement advertisement = new Advertisement();
        advertisement.setImage(advDto.getImage());
        advertisement.setNumPlace(advDto.getNumPlace());
        advertisement.setClient(client);
        advertisement.setPackage1(package1);

        return _jpa.save(advertisement);
    }

    public boolean update(int id) {
        Advertisement ad = _jpa.findById(id).orElse(null);
        if (ad != null) {
            if (ad.getPackage1().getEnteries() == ad.getNumEnteries() ||
                    ad.getPackage1().getDays() < Duration.between(ad.getTime().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays()) {
                ad.setActive(false);
                _jpa.save(ad);
                return true;
            } else {
                ad.setNumEnteries(ad.getNumEnteries() + 1);
                _jpa.save(ad);
                return false;
            }
        }
        return true;
    }

    public Advertisement get(int place) {
        ArrayList<Advertisement> ads = (ArrayList<Advertisement>) _jpa.findAll();
        for (Advertisement ad : ads) {
            if (ad.getNumPlace() == place) {
                if (!update(ad.getId())) {
                    return ad;
                }
            }
        }
        return null;
    }
}

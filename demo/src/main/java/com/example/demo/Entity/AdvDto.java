package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvDto {
    private String image;        // כתובת או שם של קובץ תמונה
    private int numPlace;         // מספר המקום
    private String clientEmail;   // המייל של הלקוח
    private int packageId;        // קוד החבילה
}

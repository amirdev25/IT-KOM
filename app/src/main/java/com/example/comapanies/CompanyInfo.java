package com.example.comapanies;

public class CompanyInfo {
    String companyName;
    String CompanyDescription;
    int image;
    int founderImage;
    String founderName;
    String founderDescription;

    public CompanyInfo(String companyName, String companyDescription, int image, int founderImage, String founderName, String founderDescription) {
        this.companyName = companyName;
        CompanyDescription = companyDescription;
        this.image = image;
        this.founderImage = founderImage;
        this.founderName = founderName;
        this.founderDescription = founderDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyDescription() {
        return CompanyDescription;
    }
    public int getImage() {
        return image;
    }



    public int getFounderImage() {
        return founderImage;
    }



    public String getFounderName() {
        return founderName;
    }



    public String getFounderDescription() {
        return founderDescription;
    }

}
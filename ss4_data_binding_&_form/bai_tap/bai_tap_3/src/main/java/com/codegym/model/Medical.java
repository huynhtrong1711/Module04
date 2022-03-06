package com.codegym.model;

public class Medical {
    private String fullName;
    private  int birthday;
    private boolean gender;
    private String national;
    private String idCard;
    private String travelInformation;
    private String numberOfSeat;
    private String travelNum;
    private String startDay;
    private String endDay;
    private String twoWeeksInformation;
    private String province;
    private String district;
    private String address;
    private String precinct;
    private String phone;
    private String email;
    private boolean temperature;
    private boolean ho;
    private boolean khoTho;
    private boolean dauHong;
    private boolean buonNon;
    private boolean tieuChay;
    private boolean xuatHuyetNgoaiDa;
    private boolean NoiBanNgoaiDa;
    private boolean tiepXucF0;
    private boolean tiepXucDongVat;

    public Medical() {
    }

    public Medical(String fullName, int birthday, boolean gender, String national, String idCard, String travelInformation,
                   String numberOfSeat, String travelNum, String startDay, String endDay, String twoWeeksInformation,
                   String province, String district, String address, String precinct, String phone, String email,
                   boolean temperature, boolean ho, boolean khoTho, boolean dauHong, boolean buonNon, boolean tieuChay,
                   boolean xuatHuyetNgoaiDa, boolean noiBanNgoaiDa, boolean tiepXucF0, boolean tiepXucDongVat) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.numberOfSeat = numberOfSeat;
        this.travelNum = travelNum;
        this.startDay = startDay;
        this.endDay = endDay;
        this.twoWeeksInformation = twoWeeksInformation;
        this.province = province;
        this.district = district;
        this.address = address;
        this.precinct = precinct;
        this.phone = phone;
        this.email = email;
        this.temperature = temperature;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.buonNon = buonNon;
        this.tieuChay = tieuChay;
        this.xuatHuyetNgoaiDa = xuatHuyetNgoaiDa;
        NoiBanNgoaiDa = noiBanNgoaiDa;
        this.tiepXucF0 = tiepXucF0;
        this.tiepXucDongVat = tiepXucDongVat;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(String numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getTravelNum() {
        return travelNum;
    }

    public void setTravelNum(String travelNum) {
        this.travelNum = travelNum;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTwoWeeksInformation() {
        return twoWeeksInformation;
    }

    public void setTwoWeeksInformation(String twoWeeksInformation) {
        this.twoWeeksInformation = twoWeeksInformation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrecinct() {
        return precinct;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTemperature() {
        return temperature;
    }

    public void setTemperature(boolean temperature) {
        this.temperature = temperature;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKhoTho() {
        return khoTho;
    }

    public void setKhoTho(boolean khoTho) {
        this.khoTho = khoTho;
    }

    public boolean isDauHong() {
        return dauHong;
    }

    public void setDauHong(boolean dauHong) {
        this.dauHong = dauHong;
    }

    public boolean isBuonNon() {
        return buonNon;
    }

    public void setBuonNon(boolean buonNon) {
        this.buonNon = buonNon;
    }

    public boolean isTieuChay() {
        return tieuChay;
    }

    public void setTieuChay(boolean tieuChay) {
        this.tieuChay = tieuChay;
    }

    public boolean isXuatHuyetNgoaiDa() {
        return xuatHuyetNgoaiDa;
    }

    public void setXuatHuyetNgoaiDa(boolean xuatHuyetNgoaiDa) {
        this.xuatHuyetNgoaiDa = xuatHuyetNgoaiDa;
    }

    public boolean isNoiBanNgoaiDa() {
        return NoiBanNgoaiDa;
    }

    public void setNoiBanNgoaiDa(boolean noiBanNgoaiDa) {
        NoiBanNgoaiDa = noiBanNgoaiDa;
    }

    public boolean isTiepXucF0() {
        return tiepXucF0;
    }

    public void setTiepXucF0(boolean tiepXucF0) {
        this.tiepXucF0 = tiepXucF0;
    }

    public boolean isTiepXucDongVat() {
        return tiepXucDongVat;
    }

    public void setTiepXucDongVat(boolean tiepXucDongVat) {
        this.tiepXucDongVat = tiepXucDongVat;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", national='" + national + '\'' +
                ", idCard='" + idCard + '\'' +
                ", travelInformation='" + travelInformation + '\'' +
                ", numberOfSeat='" + numberOfSeat + '\'' +
                ", travelNum='" + travelNum + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", twoWeeksInformation='" + twoWeeksInformation + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", precinct='" + precinct + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", temperature=" + temperature +
                ", ho=" + ho +
                ", khoTho=" + khoTho +
                ", dauHong=" + dauHong +
                ", buonNon=" + buonNon +
                ", tieuChay=" + tieuChay +
                ", xuatHuyetNgoaiDa=" + xuatHuyetNgoaiDa +
                ", NoiBanNgoaiDa=" + NoiBanNgoaiDa +
                ", tiepXucF0=" + tiepXucF0 +
                ", tiepXucDongVat=" + tiepXucDongVat +
                '}';
    }
}

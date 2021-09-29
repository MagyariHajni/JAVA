package ro.sci.phoneType.samsung.samsungTypes;

import ro.sci.phoneType.Phone;
import ro.sci.phoneType.samsung.Samsung;
import ro.sci.util.Util;
import ro.sci.util.UtilPhone;

import java.util.Scanner;

public class SamsungGalaxyA22 extends Samsung {
    private long imei;
    private long ownNumber;

    public SamsungGalaxyA22() {
        this.imei = Util.getGeneratedLong();
        this.ownNumber = UtilPhone.addNumber();

        Phone phoneInfo = new Phone();
        phoneInfo.setPhoneInfo(this.ownNumber);

        phoneInfo.setType(this.getClass().getSimpleName()+" / imei - "+this.imei);

        System.out.println(phoneInfo);
    }

    @Override
    public long getOwnNumber() {
        return ownNumber;
    }
}

package ro.sci.phoneType.nokia.nokiaTypes;

import ro.sci.phoneType.Phone;
import ro.sci.phoneType.nokia.Nokia;
import ro.sci.util.Util;
import ro.sci.util.UtilPhone;

import java.util.Scanner;


public class NokiaC10 extends Nokia {

    private long imei;
    private long ownNumber;

    public NokiaC10() {
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

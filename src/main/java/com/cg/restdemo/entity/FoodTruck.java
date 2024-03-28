package com.cg.restdemo.entity;

import com.cg.restdemo.entity.converter.FacilityTypeConverter;
import com.cg.restdemo.entity.converter.PermitStatusTypeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvRecurse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodTruck implements Serializable {

    @CsvBindByName(column = "locationId")
    private Long locationId;

    @NonNull
    @CsvBindByName(column = "Applicant")
    private String applicant;

    @CsvCustomBindByName(column = "FacilityType",converter = FacilityTypeConverter.class)
    private FacilityType facilityType;

    public enum FacilityType {
        TRUCK("Truck"),

        PUSHCART("Push Cart"),

        UNKNOWN("Unknown");

        final String value;


        FacilityType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static FacilityType getByValue(String value) {
            for (FacilityType type : FacilityType.values()) {
                if (type.getValue().contains(value)) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }

    @CsvBindByName(column = "cnn")
    private Long cnn;

    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;

    @CsvBindByName(column = "Address")
    private String address;

    @CsvRecurse
    private BlocklotInfo blocklotInfo;

    @CsvBindByName(column = "permit")
    private String permitLicense;
    @CsvCustomBindByName(column = "Status", converter = PermitStatusTypeConverter.class)
    private PermitStatus permitStatus;

    public enum PermitStatus {
        UNKNOWN,
        REQUESTED,
        APPROVED,
        EXPIRED,
        ISSUED,
        SUSPEND;

        public static PermitStatus getByValue(String value) {
            for (PermitStatus type : PermitStatus.values()) {
                if (type.values().equals(value)) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }

    /**
     * the provided food items
     */
    @CsvBindByName(column = "FoodItems")
    private String foodItems;

    @CsvRecurse
    private GeoLocationInfo geoLocationInfo;

    @CsvBindByName(column = "Schedule")
    private String permitScheduleLink;

    @CsvBindByName(column = "dayshours")
    private String permitDaysHours;

    @CsvBindByName(column = "NOISent")
    private String nioSent;

    @CsvBindByName(column = "Approved")
    private String permitApprovedDate;
    @CsvBindByName(column = "Received")
    private String permitReceivedDate;
    @CsvBindByName(column = "ExpirationDate")
    private String permitExpirationDate;

    @CsvRecurse
    private DistrictsInfo districtsInfo;
    @CsvBindByName(column = "Zip Codes")
    private String zipCodes;
    @CsvBindByName(column = "Neighborhoods (old)")
    private String neighborhoods;
}

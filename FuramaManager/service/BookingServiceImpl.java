package m2_case_study.FuramaManager.service;

import m2_case_study.FuramaManager.model.Booking;
import m2_case_study.FuramaManager.model.Facility;
import m2_case_study.FuramaManager.util.CommonUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService{
    private static TreeSet<Booking> bookings= new TreeSet<>();
    private FacilityService facilityService = new FacilityServiceImpl();

    static {
        LocalDate startDate= LocalDate.parse("01/01/2021", CommonUtil.getDateFormat());
        LocalDate endDate= LocalDate.parse("23/09/2022", CommonUtil.getDateFormat());
        bookings.add(new Booking("BOK01", startDate , endDate,"C1", "VIL01"));
    }

    @Override
    public void create(Booking booking) {
        bookings.add(booking);

        Optional<Facility> optionalFacility = facilityService.get(booking.getFacilityCode());
        if(optionalFacility.isPresent()) {
            facilityService.update(facilityService.get(booking.getFacilityCode()).get());
        }
    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public List<Booking> findAll() {
        return bookings.stream().toList();
    }
}

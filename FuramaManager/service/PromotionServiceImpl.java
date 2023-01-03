package m2_case_study.FuramaManager.service;

import m2_case_study.FuramaManager.model.Booking;
import m2_case_study.FuramaManager.model.Customer;
import m2_case_study.FuramaManager.util.ConstantUtil.PROMOTION;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PromotionServiceImpl implements PromotionService {
    private BookingService bookingService = new BookingServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    public List<Booking> getCustomerUseService(int year) {
        return bookingService.findAll().stream().filter(e -> e.getStartDate().getYear() == year).collect(Collectors.toList());
    }

    @Override
    public Map<Customer, Integer> getCustomerVoucher(int amountOfTenPercent, int amountOfTwentyPercent, int amountOfFiftyPercent) {
        Map<Customer, Integer> res = new LinkedHashMap<>();
        LocalDate now = LocalDate.now();

        List<Booking> bookings = bookingService.findAll().stream().filter(e -> e.getStartDate().getYear() == now.getYear()
                && e.getStartDate().getMonthValue() == now.getMonthValue()).collect(Collectors.toList());

        for (int i = bookings.size() - 1; i > 0; i--) {
            Customer customer = customerService.get(bookings.get(i).getCustomerCode()).get();
            if (res.size() < amountOfFiftyPercent) {
                if (!res.containsKey(customer)) {
                    res.put(customer, PROMOTION.FIFTY_PERCENT);
                }
            } else if (res.size() < amountOfFiftyPercent + amountOfTwentyPercent) {
                if (!res.containsKey(customer)) {
                    res.put(customer, PROMOTION.TWENTY_PERCENT);
                }
            } else if (res.size() < amountOfTenPercent + amountOfTwentyPercent + amountOfFiftyPercent) {
                if (!res.containsKey(customer)) {
                    res.put(customer, PROMOTION.TEN_PERCENT);
                }
            }
        }

        return res;
    }
}

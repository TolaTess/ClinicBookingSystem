package com.tolaotesanya.web.application;


import com.tolaotesanya.springclinic.business.domain.BookAppointment;
import com.tolaotesanya.springclinic.business.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method= RequestMethod.GET)
    public String getAppointment(@RequestParam(value="date", required=false)
                                         String dateString, Model model){
        List<BookAppointment> bookAppointmentList = this.appointmentService
                .getBookAppointmentForDate(dateString);
        model.addAttribute("bookAppointments", bookAppointmentList);
        return "admin";
    }
}

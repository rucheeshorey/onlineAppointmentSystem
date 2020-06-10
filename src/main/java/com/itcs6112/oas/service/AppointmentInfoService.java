package com.itcs6112.oas.service;

import com.itcs6112.oas.model.AppointmentInfo;
import com.itcs6112.oas.model.DoctorInfo;
import com.itcs6112.oas.model.PatientInfo;
import com.itcs6112.oas.model.UserInfo;
import com.itcs6112.oas.repository.AppointmentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class AppointmentInfoService{

    @Autowired
    private AppointmentInfoRepository appointmentInfoRepository;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private DoctorInfoService doctorInfoService;
    @Autowired
    private PatientInfoService patientInfoService;
    
    public AppointmentInfoService(AppointmentInfoRepository appointmentInfoRepository){
        this.appointmentInfoRepository = appointmentInfoRepository;
    }
    
    public String getInfoString(AppointmentInfo appt){
        DoctorInfo doctorInfo = this.doctorInfoService.findById(appt.getDoctorInfoId());
        UserInfo userInfo_1 = this.userInfoService.findById(doctorInfo.getUserInfoId());
        PatientInfo patientInfo = this.patientInfoService.findById(appt.getPatientInfoId());
        UserInfo userInfo_2 = this.userInfoService.findById(patientInfo.getUserInfoId());
        String doc_name = userInfo_1.getFname() + " " + userInfo_1.getLname();
        String pat_name = userInfo_2.getFname() + " " + userInfo_2.getLname();
        String date = appt.getStartDate().toString();
        return String.format("Doctor: %s Patient: %s Date: %s",doc_name,pat_name,date);
        // return String.format("Doctor: %s Patient: %S Date: %s", this.getDoctorName(pat),this.getPatientName(pat),this.getStartDate(pat));
    }
    
    public String getPatientName(AppointmentInfo appt){
        PatientInfo patientInfo = this.patientInfoService.findById(appt.getDoctorInfoId());
        UserInfo userInfo= this.userInfoService.findById(patientInfo.getUserInfoId());
		return userInfo != null ? userInfo.getFname() + " " + userInfo.getLname(): "N/A";
    }
    
    public String getDoctorName(AppointmentInfo appt){
        DoctorInfo doctorInfo = this.doctorInfoService.findById(appt.getDoctorInfoId());
        UserInfo userInfo= this.userInfoService.findById(doctorInfo.getUserInfoId());
		return userInfo != null ? userInfo.getFname() + " " + userInfo.getLname(): "N/A";
    }

    public String getStartDate(AppointmentInfo doc){
        // DoctorInfo doctorInfo = this.doctorInfoService.findById(doc.getDoctorInfoId());
        // UserInfo userInfo= this.userInfoService.findById(doctorInfo.getUserInfoId());
        // return userInfo != null ? userInfo.getFname() + " " + userInfo.getLname(): "N/A";
        return doc.getStartDate().toString();
    }

	// public String getDoctorEmail(DoctorInfo doc){
    //     UserInfo userInfo = this.userInfoService.findById(doc.getUserInfoId());
	// 	return userInfo != null ? userInfo.getEmail() : "N/A";
    // }
	// public String getDoctorSpecialty(DoctorInfo doc){
	// 	return doc.getSpecialty();
    // }

    
    public Optional<AppointmentInfo> findById(Integer id) {
        return appointmentInfoRepository.findById(id);
    }

    public Iterable<AppointmentInfo> getAllAppointments() {
        return appointmentInfoRepository.findAll();
    }

    public void saveAppointment(AppointmentInfo user) {
        appointmentInfoRepository.save(user);
    }
    
}

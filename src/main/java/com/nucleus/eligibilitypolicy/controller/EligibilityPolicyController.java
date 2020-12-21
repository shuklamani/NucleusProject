package com.nucleus.eligibilitypolicy.controller;

import com.nucleus.eligibilitypolicy.model.EligibilityPolicy;
import com.nucleus.eligibilitypolicy.service.EligibilityPolicyService;
import com.nucleus.eligibiltyparameter.database.EligibilityParameterDAO;
import com.nucleus.eligibiltyparameter.model.EligibilityParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("eligibilityPolicy")
public class EligibilityPolicyController {

    @Autowired
    EligibilityPolicyService eligibilityPolicyService;

    @Autowired
    EligibilityParameterDAO eligibilityParameterDAO;

    public EligibilityPolicyService getEligibilityPolicyService() {
        return eligibilityPolicyService;
    }

    public void setEligibilityPolicyService(EligibilityPolicyService eligibilityPolicyService) {
        this.eligibilityPolicyService = eligibilityPolicyService;
    }

    @GetMapping(value = {"/", ""})
    public ModelAndView showAllEligibilityPolicies() {
        ModelAndView modelAndView = new ModelAndView();
        List<EligibilityPolicy> eligibilityPolicyList = eligibilityPolicyService.getAllEligibilityPolicies();
        modelAndView.addObject("eligibilityPolicyList", eligibilityPolicyList);
        modelAndView.setViewName("views/eligibilitypolicies/viewEligibilityPolicies");
        return modelAndView;
    }

    @GetMapping(value = {"/new"})
    public ModelAndView newEligibilityPolicy() {
        ModelAndView modelAndView = new ModelAndView();
        EligibilityPolicy eligibilityPolicy = new EligibilityPolicy();
        List<EligibilityParameter> eligibilityParameterList = eligibilityParameterDAO.getAll();
        modelAndView.addObject("eligibilityPolicy", eligibilityPolicy);
        modelAndView.addObject("allEligibilityParameterList", eligibilityParameterList);
        modelAndView.setViewName("views/eligibilitypolicies/newEligibilityPolicy");
        return modelAndView;
    }

    @PostMapping(value = {"/add"})
    public String addEligibilityPolicy(@RequestParam("action")String action,
                                       @RequestParam("count")String parameterCountString,
                                       @ModelAttribute("eligibilityPolicy") EligibilityPolicy eligibilityPolicy,
                                       Model model) {

        if(action.equalsIgnoreCase("save")) {
            eligibilityPolicy.setStatus("INACTIVE");
        } else if (action.equalsIgnoreCase("save & request approval")) {
            eligibilityPolicy.setStatus("PENDING");
        }

        eligibilityPolicy.setCreateDate(LocalDate.now());

        List<EligibilityParameter> eligibilityParameters = new ArrayList<>();

        int parameterCount = Integer.parseInt(parameterCountString);
        for(int i=0; i<parameterCount; i++) {
            eligibilityParameters.add(eligibilityPolicyService.getOneParameterFromName(eligibilityPolicy.getEligibilityParameterNames()[i]));
        }
        eligibilityPolicy.setEligibilityParameterList(eligibilityParameters);
        boolean insertStatus = eligibilityPolicyService.insertEligibilityPolicy(eligibilityPolicy);
        model.addAttribute("insertStatus", insertStatus);
        return "redirect:/eligibilityPolicy/";
    }

    @GetMapping(value = {"/get/{policyCode}"})
    public ModelAndView showOneEligibilityPolicy(@PathVariable("policyCode") String policyCode) {
        ModelAndView modelAndView = new ModelAndView();
        EligibilityPolicy eligibilityPolicy = eligibilityPolicyService.getOneEligibilityPolicy(policyCode);
        modelAndView.addObject("eligibilityPolicy", eligibilityPolicy);
        modelAndView.setViewName("views/eligibilitypolicies/viewOneEligibilityPolicy");
        return modelAndView;
    }

    @PostMapping(value = {"/get/updateStatus/{policyCode}"})
    public String updateStatus(@PathVariable("policyCode") String policyCode, @RequestParam("action")String action, Model model) {
        boolean updateStatus = eligibilityPolicyService.updateStatus(policyCode, action);
        model.addAttribute("updateStatus", updateStatus);
        return "redirect:/eligibilityPolicy/";
    }

    @GetMapping(value = {"/edit/{policyCode}"})
    public String getEditPolicyPage(@PathVariable("policyCode") String policyCode, Model model) {
        EligibilityPolicy eligibilityPolicy = eligibilityPolicyService.getOneEligibilityPolicy(policyCode);
        List<EligibilityParameter> existingParameterList = eligibilityPolicy.getEligibilityParameterList();
        List<EligibilityParameter> allEligibilityParameterList = eligibilityParameterDAO.getAll();

        model.addAttribute("eligibilityPolicy", eligibilityPolicy);
        model.addAttribute("existingParameterList", existingParameterList);
        model.addAttribute("allEligibilityParameterList", allEligibilityParameterList);
        return "views/eligibilitypolicies/editOneEligibilityPolicy";
    }

    @PostMapping(value = {"edit/addEdited"})
    public String addEditedEligibilityPolicy(@RequestParam("action")String action,
                                       @RequestParam("count")String parameterCountString,
                                       @ModelAttribute("eligibilityPolicy") EligibilityPolicy eligibilityPolicy,
                                       Model model) {

        if(action.equalsIgnoreCase("save")) {
            eligibilityPolicy.setStatus("INACTIVE");
        } else if (action.equalsIgnoreCase("save & request approval")) {
            eligibilityPolicy.setStatus("PENDING");
        }

        eligibilityPolicy.setCreateDate(LocalDate.now());

        List<EligibilityParameter> eligibilityParameters = new ArrayList<>();

        int parameterCount = Integer.parseInt(parameterCountString);
        for(int i=0; i<parameterCount; i++) {
            eligibilityParameters.add(eligibilityPolicyService.getOneParameterFromName(eligibilityPolicy.getEligibilityParameterNames()[i]));
        }
        eligibilityPolicy.setEligibilityParameterList(eligibilityParameters);
        boolean editStatus = eligibilityPolicyService.updateEligibilityPolicy(eligibilityPolicy);
        model.addAttribute("editStatus", editStatus);
        return "redirect:/eligibilityPolicy/";
    }

    @GetMapping(value = {"/delete/{policyCode}"})
    public String deletePolicy(@PathVariable("policyCode") String policyCode, Model model) {
        boolean deleteStatus = eligibilityPolicyService.deleteEligibilityPolicy(policyCode);
        model.addAttribute("deleteStatus", deleteStatus);
        return "redirect:/eligibilityPolicy/";
    }
}

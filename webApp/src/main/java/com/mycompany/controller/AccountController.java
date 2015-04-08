package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.domain.Account;
import com.mycompany.domain.Transfer;
import com.mycompany.services.AccountService;
import java.util.ArrayList;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("user_account_form")
    public ModelAndView getForm(@ModelAttribute Account account) {
        return new ModelAndView("user_account_form");
    }

    @RequestMapping("user_account_register")
    public ModelAndView registerAccount(@ModelAttribute Account account) {
        accountService.insertRow(account);
        return new ModelAndView("redirect:user_account_list");
    }

    @RequestMapping("user_account_list")
    public ModelAndView getList() {
        List accountList = accountService.getList();
        return new ModelAndView("user_account_list", "accountList", accountList);
    }

    @RequestMapping("user_account_delete")
    public ModelAndView deleteAccount(@RequestParam int id) {
        accountService.deleteRow(id);
        return new ModelAndView("redirect:user_account_list");
    }

    @RequestMapping("user_account_edit")
    public ModelAndView editAccount(@RequestParam int id, @ModelAttribute Account account) {
        Account accountObject = accountService.getRowById(id);
        return new ModelAndView("user_account_edit", "accountObject", accountObject);
    }

    @RequestMapping("user_account_update")
    public ModelAndView updateAccount(@ModelAttribute Account account) {
        accountService.updateRow(account);
        return new ModelAndView("redirect:user_account_list");
    }

    @RequestMapping("user_account_transfer")
    public ModelAndView transferAccount(@ModelAttribute Transfer transfer) {
        return new ModelAndView("user_account_transfer", "transfer", transfer);
    }

    @RequestMapping("user_account_transfer_update")
    public ModelAndView updateTransfer(@ModelAttribute Transfer transfer) {
        accountService.updateRows(transfer.getFrom(), transfer.getTo(), transfer.getAmount());
        return new ModelAndView("redirect:user_account_list");
    }

}

package com.project.server.controller;

import com.project.server.repository.Data2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Data2Controller {
    @Autowired
    private Data2Repository data2Repository;
}

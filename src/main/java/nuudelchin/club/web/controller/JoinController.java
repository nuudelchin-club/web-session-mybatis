package nuudelchin.club.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import nuudelchin.club.web.dto.JoinDTO;
import nuudelchin.club.web.service.JoinService;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;


    @GetMapping("/join")
    public String join() {

        return "join";
    }


    @PostMapping("/joinProc")
    public String joinProc(JoinDTO dto) {

        System.out.println(dto.getUsername());

        joinService.joinProc(dto);

        return "redirect:/login";
    }
}

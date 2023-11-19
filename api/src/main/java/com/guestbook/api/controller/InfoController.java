package com.guestbook.api.controller;

import com.guestbook.api.dto.InfoDto;
import com.guestbook.api.repository.InfoRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {

    private final InfoRepository repository;

    @GetMapping()
    public InfoDto getInfo(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        InfoDto info = new InfoDto();
        info.setName(repository.getName());
        return info;
    }

    @PostMapping()
    public InfoDto setName(@RequestParam String name, HttpServletResponse resp) {
        repository.setName(name);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        InfoDto info = new InfoDto();
        info.setName(repository.getName());
        return info;
    }


}

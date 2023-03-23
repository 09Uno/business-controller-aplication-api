package com.codetoyou.businessapi.rest.sell;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetoyou.businessapi.model.SellModel;
import com.codetoyou.businessapi.model.repository.ItemSellRepository;
import com.codetoyou.businessapi.model.repository.SellRepository;



    @RestController
    @RequestMapping("/api/sell")


    @CrossOrigin(origins = "*")
public class SellController {


    @Autowired 
    private SellRepository sellRepository;
    @Autowired ItemSellRepository itemSellRepository;

    @PostMapping
    @Transactional
    public void save(@RequestBody SellModel sellModel){
        sellRepository.save(sellModel);
        sellModel.getItem().stream().forEach( is -> is.setSell(sellModel));

        itemSellRepository.saveAll(sellModel.getItem());

    }



}
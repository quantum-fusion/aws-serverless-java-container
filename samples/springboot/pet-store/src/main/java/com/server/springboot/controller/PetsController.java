/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.server.springboot.controller;



import com.server.springboot.model.Pet;
import com.server.springboot.model.PetData;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.context.annotation.ComponentScan;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;



@EnableWebMvc
@RestController
//@RequestMapping("/petstore")
@ComponentScan("com.server.springboot.controller")
public class PetsController {
    @RequestMapping(path = "/pets", method = RequestMethod.POST)
    public Pet createPet(@RequestBody Pet newPet) {
        if (newPet.getName() == null || newPet.getBreed() == null) {
            return null;
        }

        Pet dbPet = newPet;
        dbPet.setId(UUID.randomUUID().toString());
        return dbPet;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public Pet[] listPets(@RequestParam("limit") Optional<Integer> limit, Principal principal) {

        try {

            int queryLimit = 10;
            if (limit.isPresent()) {
                queryLimit = limit.get();
            }

            Pet[] outputPets = new Pet[queryLimit];

            for (int i = 0; i < queryLimit; i++) {
                Pet newPet = new Pet();
                newPet.setId(UUID.randomUUID().toString());
                newPet.setName(PetData.getRandomName());
                newPet.setBreed(PetData.getRandomBreed());
                newPet.setDateOfBirth(PetData.getRandomDoB());
                outputPets[i] = newPet;
            }

            return outputPets;
        }
        catch (Exception e)
        {
            Pet[] blankPets = new Pet[1];
            return blankPets;
        }

    }

    @RequestMapping(path = "/pets/{petId}", method = RequestMethod.GET)
    public Pet listPets() {
        Pet newPet = new Pet();
        newPet.setId(UUID.randomUUID().toString());
        newPet.setBreed(PetData.getRandomBreed());
        newPet.setDateOfBirth(PetData.getRandomDoB());
        newPet.setName(PetData.getRandomName());
        return newPet;
    }

    @RequestMapping(path = "/helloworld", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloworld() {

        //   logger.info("helloworld");

        return "helloworld!";
    }

    @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {

        //  logger.info("Greetings from Rest Server!");

        return "Greetings from Rest Server!";
    }

    @RequestMapping(path = "/postMessage", method = {RequestMethod.GET, RequestMethod.POST})
    public String postMessage(@RequestBody String jsonRequest) {

        //    logger.info("jsonRequest:" + jsonRequest);

        return "200/OK";

    }

    @RequestMapping(value = "/greeting", method = {RequestMethod.GET, RequestMethod.POST})
    public String greeting() {

        //     logger.info("greeting info message" + json);

        return "greeting info message";
    }





}

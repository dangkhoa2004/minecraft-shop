/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minecraft.shop.repository;

import com.minecraft.shop.model.Gameplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 04dkh
 */

@Repository
public interface GameplayRepository extends JpaRepository<Gameplay, Integer>{
    
}

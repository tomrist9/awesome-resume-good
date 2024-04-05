package com.example.awesomeresume.dao.inter;

import com.example.awesomeresume.entity.Country;
import com.example.awesomeresume.entity.UserSkill;

import java.util.List;

public interface CountryDaoInter {
    public List<Country> getAllCountriesByUserId(int userId);
}

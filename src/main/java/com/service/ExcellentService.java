package com.service;

import com.model.Excellent;


import java.util.List;


public interface ExcellentService {
    List<Excellent> show();

    Boolean add(Excellent excellent);

    Boolean update(Excellent excellent);

    Excellent showOne(long id);

    Boolean  delete(long id);


}

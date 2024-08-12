package org.example.admin.Service;

import io.jsonwebtoken.Claims;
import org.example.admin.pojo.course;

import java.util.List;

public interface courseService {
    List<course> list();
    List<course> mylist(int sid);
    void add(int cid,int sid);
    void delete(int cid);
}

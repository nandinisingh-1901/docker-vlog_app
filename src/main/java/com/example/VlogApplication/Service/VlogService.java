package com.example.VlogApplication.Service;

import com.example.VlogApplication.Model.Vlog;
import com.example.VlogApplication.Repo.VlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VlogService {

    @Autowired
    private VlogRepo vlogRepo;

    public List<Vlog> getAllVlogs() {

        return vlogRepo.findAll();
    }

    public void createVlog(Vlog vlog){
        vlog.setDateCreated(new Date());
        vlogRepo.save(vlog);
    }

//    public void deleteVlog(Integer id){
//        vlogRepo.deleteById(id);
//    }

    public void deleteById(Integer id) {
        vlogRepo.deleteById(id);
    }

    public Optional<Vlog> findById(Integer id) {
        return vlogRepo.findById(id);
    }

    public void deleteAllVlogs(){
        vlogRepo.deleteAll();
    }
    public List<Vlog> getVlogByTitle(String title){
        return vlogRepo.findByTitleContaining(title);
    }
}

package friendsofmine.m2.services;

import friendsofmine.m2.domain.Inscription;
import friendsofmine.m2.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public Inscription saveInscription(Inscription inscription) {
        if (inscription == null)
            throw new IllegalArgumentException("Inscription must not be null");
        return inscriptionRepository.save(inscription);
    }

    public Page<Inscription> findAllInscription(Pageable pageable) {
        return inscriptionRepository.findAll(pageable);
    }

    public Page<Inscription> findInscription(String nom, String titre, Pageable pageable) {
        return inscriptionRepository.findByParticipantNomOrActiviteTitreAllIgnoreCase(nom, titre, pageable);
    }

    public void deleteInscription(Long id) {
        inscriptionRepository.deleteById(id);
    }

    public Inscription findInscriptionById(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    public long countInscription() {
        return inscriptionRepository.count();
    }

    public ArrayList<Inscription> findAllInscription() {
        Iterable<Inscription> ins = inscriptionRepository.findAll();
        ArrayList<Inscription> insList = new ArrayList<>();
        ins.forEach(insList::add);
        return insList;
    }

    public ArrayList<Inscription> findInscription(String nom, String titre) {
        return inscriptionRepository.findByParticipantNomOrActiviteTitreAllIgnoreCase(nom, titre);
    }

    public InscriptionRepository getInscriptionRepository() {
        return inscriptionRepository;
    }

    public void setInscriptionRepository(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }
}

package friendsofmine.m2.services;

import friendsofmine.m2.domain.Activite;
import friendsofmine.m2.repositories.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository ;

    // @Autowired
    // private UtilisateurRepository utilisateurRepository;

    /*
    public Activite saveActivite(Activite activite) {
        if (activite == null)
            throw new IllegalArgumentException("Activite must not be null");

        Utilisateur savedResponsable = utilisateurRepository.save(activite.getResponsable());
        Activite savedActivite = activiteRepository.save(activite);

        savedResponsable.addActivite(savedActivite);
        return savedActivite;
    }
    */

    public Activite findActiviteById(Long id) {
        return activiteRepository.findById(id).orElse(null);
    }

    public long countActivite() {
        return activiteRepository.count();
    }

    public ArrayList<Activite> findAllActivites() {
        Iterable<Activite> activites = activiteRepository.findAll();
        ArrayList<Activite> activiteList = new ArrayList<>();
        activites.forEach(activiteList::add);
        activiteList.sort(Comparator.comparing(Activite::getTitre));
        return activiteList;
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public void setActiviteRepository(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

}

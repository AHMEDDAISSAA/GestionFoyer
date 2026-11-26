package tn.esprim.gestionfoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.gestionfoyer.entities.Chambre;
import tn.esprim.gestionfoyer.entities.TypeChambre;
import tn.esprim.gestionfoyer.repositories.ChambreRepository;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreID) {
        return chambreRepository.findById(chambreID).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreID) {
        chambreRepository.deleteById(chambreID);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambreParNomUniversite(String nomUniversite) {
        return chambreRepository.trouverChambreParNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.trouverChambreParBlocAndType(idBloc, typeC);
    }
}
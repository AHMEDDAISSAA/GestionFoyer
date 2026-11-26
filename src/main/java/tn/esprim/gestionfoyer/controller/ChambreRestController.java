package tn.esprim.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprim.gestionfoyer.entities.Chambre;
import tn.esprim.gestionfoyer.entities.TypeChambre;
import tn.esprim.gestionfoyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Chambre")
public class ChambreRestController {

    @GetMapping("/getChambreParNomUniversite/{nomUniv}")
    public List<Chambre> getChambreParNomUniversite(
            @PathVariable("nomUniv") String nomUniversite) {
        return chambreService.getChambreParNomUniversite(nomUniversite);
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambreParBlocEtType(
            @PathVariable("idBloc") Long idBloc,
            @PathVariable("typeC") TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }


    @Autowired
    private IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}


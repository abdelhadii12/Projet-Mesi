package com.caroca.Caroca_Mesi.VoitureResource;

import com.caroca.Caroca_Mesi.Services.VoitureService;
import com.caroca.Caroca_Mesi.Model.VoitureDTO;
import com.caroca.Caroca_Mesi.Model.VoitureInfo;
import com.caroca.Caroca_Mesi.Services.UserService;
import com.caroca.Caroca_Mesi.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/voiture")
public class VoitureResource {
    private final VoitureService voitureService;
    private final UserService userService;

    public VoitureResource(VoitureService voitureService, UserService userService) {
        this.voitureService = voitureService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<VoitureInfo>> getAllVoitureInfo() {
        List<VoitureInfo> voitureInfos = voitureService.FindAllVoiture();
        return new ResponseEntity<>(voitureInfos, HttpStatus.OK);
    }

    @GetMapping("/find/{Id}")
    public ResponseEntity<VoitureInfo> getVoitureById(@PathVariable("Id") Long Id) {
        VoitureInfo voitureInfos = voitureService.findVoitureById(Id);
        return new ResponseEntity<>(voitureInfos, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VoitureInfo> addVoiture(
            @RequestParam("marque") String marque,
            @RequestParam("modele") String modele,
            @RequestParam("annee") int annee,
            @RequestParam("prix") double prix,
            @RequestParam("couleur") String couleur,
            @RequestParam("kilometrage") long kilometrage,
            @RequestParam("typeCarbu") String typeCarbu,
            @RequestParam("trans") String trans,
            @RequestParam("description") String description,
            @RequestParam(value = "images", required = false) List<MultipartFile> images) throws IOException {
        
        VoitureDTO voitureDTO = new VoitureDTO();
        voitureDTO.setMarque(marque);
        voitureDTO.setModele(modele);
        voitureDTO.setAnnee(annee);
        voitureDTO.setPrix(prix);
        voitureDTO.setCouleur(couleur);
        voitureDTO.setKilometrage(kilometrage);
        voitureDTO.setTypeCarbu(typeCarbu);
        voitureDTO.setTrans(trans);
        voitureDTO.setDescription(description);
        voitureDTO.setImages(images);

        VoitureInfo newVoiture = voitureService.addVoiture(voitureDTO);
        return new ResponseEntity<>(newVoiture, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VoitureInfo> updateVoiture(
            @RequestParam("id") Long id,
            @RequestParam("marque") String marque,
            @RequestParam("modele") String modele,
            @RequestParam("annee") int annee,
            @RequestParam("prix") double prix,
            @RequestParam("couleur") String couleur,
            @RequestParam("kilometrage") long kilometrage,
            @RequestParam("typeCarbu") String typeCarbu,
            @RequestParam("trans") String trans,
            @RequestParam("description") String description,
            @RequestParam(value = "images", required = false) List<MultipartFile> images) throws IOException {
        
        VoitureDTO voitureDTO = new VoitureDTO();
        voitureDTO.setId(id);
        voitureDTO.setMarque(marque);
        voitureDTO.setModele(modele);
        voitureDTO.setAnnee(annee);
        voitureDTO.setPrix(prix);
        voitureDTO.setCouleur(couleur);
        voitureDTO.setKilometrage(kilometrage);
        voitureDTO.setTypeCarbu(typeCarbu);
        voitureDTO.setTrans(trans);
        voitureDTO.setDescription(description);
        voitureDTO.setImages(images);

        VoitureInfo updateVoiture = voitureService.updateVoiture(voitureDTO);
        return new ResponseEntity<>(updateVoiture, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVoiture(@PathVariable Long id, Principal principal) {
        VoitureInfo voiture = voitureService.findVoitureById(id);
        User currentUser = userService.findByEmail(principal.getName());
        if (voiture.getOwner().getId().equals(currentUser.getId()) || currentUser.getRole().equals("ADMIN")) {
            voitureService.deleteVoiture(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not allowed");
        }
    }
}


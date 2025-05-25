package com.caroca.Caroca_Mesi.Services;

import com.caroca.Caroca_Mesi.Exception.UserNotFoundException;
import com.caroca.Caroca_Mesi.Model.VoitureDTO;
import com.caroca.Caroca_Mesi.Model.VoitureInfo;
import com.caroca.Caroca_Mesi.Model.CarImage;
import com.caroca.Caroca_Mesi.repo.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class VoitureService {
    private final VoitureRepo voitureRepo;

    @Autowired
    public VoitureService(VoitureRepo voitureRepo) {
        this.voitureRepo = voitureRepo;
    }

    public VoitureInfo addVoiture(VoitureDTO voitureDTO) throws IOException {
        VoitureInfo voitureInfo = new VoitureInfo();
        voitureInfo.setMarque(voitureDTO.getMarque());
        voitureInfo.setModele(voitureDTO.getModele());
        voitureInfo.setAnnee(voitureDTO.getAnnee());
        voitureInfo.setPrix(voitureDTO.getPrix());
        voitureInfo.setCouleur(voitureDTO.getCouleur());
        voitureInfo.setKilometrage(voitureDTO.getKilometrage());
        voitureInfo.setTypeCarbu(voitureDTO.getTypeCarbu());
        voitureInfo.setTrans(voitureDTO.getTrans());
        voitureInfo.setDescription(voitureDTO.getDescription());

        if (voitureDTO.getImages() != null) {
            for (MultipartFile img : voitureDTO.getImages()) {
                CarImage carImage = new CarImage();
                carImage.setData(img.getBytes());
                carImage.setContentType(img.getContentType());
                carImage.setVoiture(voitureInfo);
                voitureInfo.getImages().add(carImage);
            }
        }
        return voitureRepo.save(voitureInfo);
    }

    public List<VoitureInfo> FindAllVoiture() {
        return voitureRepo.findAll();
    }

    public VoitureInfo updateVoiture(VoitureDTO voitureDTO) throws IOException {
        VoitureInfo existingVoiture = voitureRepo.findById(voitureDTO.getId())
                .orElseThrow(() -> new UserNotFoundException("Voiture non trouvée"));

        existingVoiture.setMarque(voitureDTO.getMarque());
        existingVoiture.setModele(voitureDTO.getModele());
        existingVoiture.setAnnee(voitureDTO.getAnnee());
        existingVoiture.setPrix(voitureDTO.getPrix());
        existingVoiture.setCouleur(voitureDTO.getCouleur());
        existingVoiture.setKilometrage(voitureDTO.getKilometrage());
        existingVoiture.setTypeCarbu(voitureDTO.getTypeCarbu());
        existingVoiture.setTrans(voitureDTO.getTrans());
        existingVoiture.setDescription(voitureDTO.getDescription());

        if (voitureDTO.getImages() != null) {
            for (MultipartFile img : voitureDTO.getImages()) {
                CarImage carImage = new CarImage();
                carImage.setData(img.getBytes());
                carImage.setContentType(img.getContentType());
                carImage.setVoiture(existingVoiture);
                existingVoiture.getImages().add(carImage);
            }
        }

        return voitureRepo.save(existingVoiture);
    }

    public VoitureInfo findVoitureById(Long id) {
        return voitureRepo.findVoitureById(id)
                .orElseThrow(() -> new UserNotFoundException("Aucune Voiture Trouvée"));
    }

    public void deleteVoiture(Long id) {
        voitureRepo.deleteById(id);
    }
}

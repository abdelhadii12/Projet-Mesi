package com.caroca.Caroca_Mesi.Services;

import com.caroca.Caroca_Mesi.Exception.UserNotFoundException;
import com.caroca.Caroca_Mesi.Model.VoitureDTO;
import com.caroca.Caroca_Mesi.Model.VoitureInfo;
import com.caroca.Caroca_Mesi.Model.CarImage;
import com.caroca.Caroca_Mesi.repo.VoitureRepo;
import com.caroca.Caroca_Mesi.Model.dto.CarImageResponseDTO;
import com.caroca.Caroca_Mesi.Model.dto.VoitureInfoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Base64;
import java.util.stream.Collectors;

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

    public List<VoitureInfoResponseDTO> FindAllVoiture() {
        List<VoitureInfo> voitureInfos = voitureRepo.findAll();
        return voitureInfos.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private VoitureInfoResponseDTO convertToDto(VoitureInfo voitureInfo) {
        List<CarImageResponseDTO> imageDTOs = null;
        if (voitureInfo.getImages() != null) {
            imageDTOs = voitureInfo.getImages().stream()
                    .map(image -> new CarImageResponseDTO(Base64.getEncoder().encodeToString(image.getData()), image.getContentType()))
                    .collect(Collectors.toList());
        }

        return new VoitureInfoResponseDTO(
                voitureInfo.getId(),
                voitureInfo.getMarque(),
                voitureInfo.getModele(),
                voitureInfo.getAnnee(),
                voitureInfo.getPrix(),
                voitureInfo.getCouleur(),
                voitureInfo.getKilometrage(),
                voitureInfo.getTypeCarbu(),
                voitureInfo.getTrans(),
                voitureInfo.getDescription(),
                imageDTOs
        );
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

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { VoitureService } from '../services/voiture.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ajouter-voiture',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './ajouter-voiture.component.html',
  styleUrls: ['./ajouter-voiture.component.css']
})
export class AjouterVoitureComponent {
  voitureForm: FormGroup;
  imgExt: File | null = null;
  imgInt: File | null = null;
  currentYear = new Date().getFullYear();
  message: string | null = null;
  imageFiles: File[] = [];
  imagePreviews: string[] = [];

  constructor(
    private fb: FormBuilder, 
    private voitureService: VoitureService,
    private router: Router
  ) {
    this.voitureForm = this.fb.group({
      marque: ['', Validators.required],
      modele: ['', Validators.required],
      annee: ['', [Validators.required, Validators.min(1900), Validators.max(this.currentYear)]],
      prix: ['', [Validators.required, Validators.min(0)]],
      couleur: ['', Validators.required],
      kilometrage: ['', [Validators.required, Validators.min(0)]],
      typeCarbu: ['', Validators.required],
      trans: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  

  onFilesSelected(event: any) {
    this.imageFiles = Array.from(event.target.files as FileList).slice(0, 3);
    this.imagePreviews = [];
    for (let file of this.imageFiles) {
      const reader = new FileReader();
      reader.onload = (e: any) => this.imagePreviews.push(e.target.result);
      reader.readAsDataURL(file);
    }
  }

  onSubmit() {
    if (this.voitureForm.valid) {
      console.log('Formulaire soumis');
      const formData = new FormData();
      
      // Add form fields
      Object.keys(this.voitureForm.controls).forEach(key => {
        const controlValue = this.voitureForm.get(key)?.value;
        if (controlValue) {
          formData.append(key, controlValue);
        }
      });

      // Add images if selected
      if (this.imageFiles.length > 0) {
        this.imageFiles.forEach((file, index) => {
          formData.append(`image${index}`, file);
        });
      }

      // Log the form data for debugging
      for (let pair of formData.entries()) {
        console.log(pair[0] + ': ' + pair[1]);
      }

      this.voitureService.addVoiture(formData).subscribe({
        next: (response) => {
          console.log('Response:', response);
          this.message = 'Voiture ajoutée avec succès !';
          setTimeout(() => {
            this.router.navigate(['/']);
          }, 500);
        },
        error: (error) => {
          console.error('Error details:', error);
          if (error.error instanceof ErrorEvent) {
            // Client-side error
            this.message = 'Erreur de connexion au serveur.';
          } else {
            // Server-side error
            this.message = `Erreur lors de l'ajout de la voiture: ${error.status} ${error.statusText}`;
          }
        }
      });
    } else {
      this.message = 'Formulaire invalide. Merci de vérifier les champs.';
      // Mark all fields as touched to show validation errors
      Object.keys(this.voitureForm.controls).forEach(key => {
        const control = this.voitureForm.get(key);
        control?.markAsTouched();
      });
    }
  }
}

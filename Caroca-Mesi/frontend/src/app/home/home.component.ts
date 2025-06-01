import { Component, OnInit } from '@angular/core';
import { VoitureService } from '../services/voiture.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common'; // Importez CommonModule
import { RouterModule } from '@angular/router'; // Importez RouterModule

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true, // Indiquez que ce composant est autonome
  imports: [CommonModule, RouterModule] // Ajoutez CommonModule et RouterModule aux imports
})
export class HomeComponent implements OnInit {
  voitures: any[] = [];
  error: string | null = null;

  constructor(private voitureService: VoitureService, private router: Router) {}

  ngOnInit(): void {
    console.log('Fetching voitures...');
    this.voitureService.getAllVoitures().subscribe({
      next: (data) => {
        console.log('Received data:', data);
        this.voitures = data;
        if (this.voitures.length === 0) {
          console.log('No voitures found in the response');
        } else {
          console.log(`Found ${this.voitures.length} voitures`);
          // Log the first voiture to check its structure
          console.log('First voiture structure:', this.voitures[0]);
        }
      },
      error: (error) => {
        console.error('Error fetching voitures:', error);
        this.error = 'Erreur lors du chargement des voitures';
      }
    });
  }

  voirDetail(id: number): void {
    this.router.navigate(['/voiture-detail', id]);
  }
}

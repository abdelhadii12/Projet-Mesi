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

  constructor(private voitureService: VoitureService, private router: Router) {}

  ngOnInit(): void {
    this.voitureService.getAllVoitures().subscribe((data) => {
      this.voitures = data;

      console.log(this.voitures);
    });
  }

  voirDetail(id: number): void {
    this.router.navigate(['/voiture-detail', id]);
  }
}

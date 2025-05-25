import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { VoitureService } from '../services/voiture.service';
import { CommonModule } from '@angular/common'; // Importez CommonModule

@Component({
  selector: 'app-voiture-detail',
  templateUrl: './voiture-detail.component.html',
  styleUrls: ['./voiture-detail.component.css'],
  standalone: true, // Indiquez que ce composant est autonome
  imports: [CommonModule, RouterModule] // Ajoutez CommonModule et RouterModule aux imports
})
export class VoitureDetailComponent implements OnInit {
  voiture: any;

  constructor(private route: ActivatedRoute, private voitureService: VoitureService) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.voitureService.getVoitureById(Number(id)).subscribe(data => {
        this.voiture = data;
      });
    }
  }
}

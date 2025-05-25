import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export interface Voiture {
  id: number;
  name: string;
  description: string;
  cheminImage: string; // Utilisez cheminImage
}

@Injectable({
  providedIn: 'root',
})
export class VoitureService {
  private baseUrl = 'http://localhost:4567';
  private imageBaseUrl = 'http://localhost:4567/images/voitures/';

  constructor(private http: HttpClient) {}

  getVoitures(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.baseUrl}/voitures`).pipe(
      map((voitures: Voiture[]) => {
        return voitures.map((voiture) => {
          voiture.cheminImage = `${this.imageBaseUrl}${voiture.id}`;
          return voiture;
        });
      })
    );
  }

  getVoitureById(id: string): Observable<Voiture> {
    return this.http.get<Voiture>(`${this.baseUrl}/voitures/${id}`).pipe(
      map((voiture: Voiture) => {
        voiture.cheminImage = `${this.imageBaseUrl}${voiture.id}`;
        return voiture;
      })
    );
  }

  
  
}

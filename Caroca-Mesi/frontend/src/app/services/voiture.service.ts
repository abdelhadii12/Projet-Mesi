import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Voiture {
  id: number;
  marque: string;
  modele: string;
  annee: number;
  prix: number;
  couleur: string;
  kilometrage: number;
  typeCarbu: string;
  trans: string;
  description: string;
  imgExt?: string;
  imgInt?: string;
  imgExtType?: string;
  imgIntType?: string;
}

@Injectable({
  providedIn: 'root',
})
export class VoitureService {
  private apiUrl = 'http://localhost:9002/voiture';

  constructor(private http: HttpClient) {}

  getAllVoitures(): Observable<Voiture[]> {
    return this.http.get<Voiture[]>(`${this.apiUrl}/all`);
  }

  getVoitureById(id: number): Observable<Voiture> {
    return this.http.get<Voiture>(`${this.apiUrl}/find/${id}`);
  }

  addVoiture(formData: FormData): Observable<Voiture> {
    return this.http.post<Voiture>(`${this.apiUrl}/add`, formData);
  }

  updateVoiture(formData: FormData): Observable<Voiture> {
    return this.http.put<Voiture>(`${this.apiUrl}/update`, formData);
  }

  deleteVoiture(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, tap, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

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
  images?: {
    data: string;
    contentType: string;
  }[];
}

@Injectable({
  providedIn: 'root',
})
export class VoitureService {
  private apiUrl = 'http://localhost:9002/voiture';

  constructor(private http: HttpClient) {}

  getAllVoitures(): Observable<Voiture[]> {
    console.log('Fetching all voitures from:', `${this.apiUrl}/all`);
    return this.http.get<Voiture[]>(`${this.apiUrl}/all`).pipe(
      tap(response => {
        console.log('Response from getAllVoitures:', response);
      }),
      catchError(error => {
        console.error('Error in getAllVoitures:', error);
        throw error;
      })
    );
  }

  getVoitureById(id: number): Observable<Voiture> {
    return this.http.get<Voiture>(`${this.apiUrl}/find/${id}`);
  }

  addVoiture(formData: FormData): Observable<Voiture> {
    return this.http.post<Voiture>(`${this.apiUrl}/add`, formData, {
      headers: new HttpHeaders({
        'Accept': 'application/json'
      }),
      observe: 'response'
    }).pipe(
      map(response => {
        if (response.body) {
          // Ensure images array exists
          if (!response.body.images) {
            response.body.images = [];
          }
          return response.body;
        }
        throw new Error('No response body received');
      })
    );
  }

  updateVoiture(formData: FormData): Observable<Voiture> {
    return this.http.put<Voiture>(`${this.apiUrl}/update`, formData);
  }

  deleteVoiture(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}

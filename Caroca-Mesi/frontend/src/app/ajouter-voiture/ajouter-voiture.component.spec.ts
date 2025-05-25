import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterVoitureComponent } from './ajouter-voiture.component';
import { ReactiveFormsModule } from '@angular/forms';

describe('AjouterVoitureComponent', () => {
  let component: AjouterVoitureComponent;
  let fixture: ComponentFixture<AjouterVoitureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AjouterVoitureComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjouterVoitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

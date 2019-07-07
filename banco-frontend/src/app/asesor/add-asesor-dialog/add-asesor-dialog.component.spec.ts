import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAsesorDialogComponent } from './add-asesor-dialog.component';

describe('AddAsesorDialogComponent', () => {
  let component: AddAsesorDialogComponent;
  let fixture: ComponentFixture<AddAsesorDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAsesorDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAsesorDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

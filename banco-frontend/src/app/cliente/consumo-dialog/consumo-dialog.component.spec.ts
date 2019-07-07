import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumoDialogComponent } from './consumo-dialog.component';

describe('ConsumoDialogComponent', () => {
  let component: ConsumoDialogComponent;
  let fixture: ComponentFixture<ConsumoDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsumoDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsumoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RenewsuccessComponent } from './renewsuccess.component';

describe('RenewsuccessComponent', () => {
  let component: RenewsuccessComponent;
  let fixture: ComponentFixture<RenewsuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RenewsuccessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RenewsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

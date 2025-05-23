import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginRoutsComponent } from './login-routs.component';

describe('LoginRoutsComponent', () => {
  let component: LoginRoutsComponent;
  let fixture: ComponentFixture<LoginRoutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginRoutsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginRoutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

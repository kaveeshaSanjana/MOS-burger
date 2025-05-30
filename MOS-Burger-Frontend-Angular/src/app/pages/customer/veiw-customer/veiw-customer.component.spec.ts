import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwCustomerComponent } from './veiw-customer.component';

describe('VeiwCustomerComponent', () => {
  let component: VeiwCustomerComponent;
  let fixture: ComponentFixture<VeiwCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeiwCustomerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiwCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

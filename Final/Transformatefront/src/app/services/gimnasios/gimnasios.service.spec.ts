import { TestBed } from '@angular/core/testing';

import { GimnasioServise } from './gimnasios.service';

describe('GimnasioServise', () => {
  let service: GimnasioServise;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GimnasioServise);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

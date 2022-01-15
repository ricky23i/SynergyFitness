import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildGuideComponent } from './build-guide.component';

describe('BuildGuideComponent', () => {
  let component: BuildGuideComponent;
  let fixture: ComponentFixture<BuildGuideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuildGuideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuildGuideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

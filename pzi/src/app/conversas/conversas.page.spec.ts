import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConversasPage } from './conversas.page';

describe('ConversasPage', () => {
  let component: ConversasPage;
  let fixture: ComponentFixture<ConversasPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ConversasPage],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConversasPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

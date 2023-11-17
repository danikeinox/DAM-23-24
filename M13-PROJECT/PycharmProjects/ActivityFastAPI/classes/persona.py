from typing import List

from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

app = FastAPI()


class Persona(BaseModel):
    id: int
    name: str
    email: str
    edat: int


db: List[Persona] = []


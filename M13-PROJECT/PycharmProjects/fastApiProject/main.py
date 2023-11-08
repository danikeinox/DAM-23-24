from datetime import datetime
from typing import List

from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

app = FastAPI()


class Persona(BaseModel):
    id: int
    name: str
    email: str
    edat: int
    data_alta: datetime
    esAdmin: bool


db: List[Persona] = []


@app.get("/persona/", response_model=List[Persona])
async def read_personas():
    return db


@app.get("/persona/{id_persona}", response_model=Persona)
async def read_id(id_persona: int):
    for persona in db:
        if persona.id == id_persona:
            return persona
    raise HTTPException(status_code=404, detail=f"ID {id_persona} not found")


@app.put("/persona/{id_persona}", response_model=Persona)
async def update_persona(id_persona: int, update_persona: Persona):
    for index, persona in enumerate(db):
        if persona.id == id_persona:
            db[index] = update_persona
            return update_persona
    raise HTTPException(status_code=404, detail=f"ID {id_persona} not found")


@app.post("/persona/", response_model=Persona)
async def create_persona(persona: Persona):
    db.append(persona)
    return persona


@app.delete("/persona/{id_persona}", status_code=204)
async def delete_persona(id_persona: int):
    for index, persona in enumerate(db):
        if persona.id == id_persona:
            db.pop(index)
            return persona
    raise HTTPException(status_code=404, detail=f"ID {id_persona} not found")


# db.append(Persona(id=1, name="daniel", email="daniel@danielcabrera.es",
# edat=22, data_alta="2023-11-07", esAdmin=True))

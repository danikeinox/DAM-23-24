from typing import List

from fastapi import FastAPI, HTTPException

from classes import docent, persona

app = FastAPI()

db: List[docent.Docent] = []


@app.get("/docents/", response_model=List[docent.Docent])
async def read_personas():
    return db


@app.get("/docents/{id_docent}", response_model=docent.Docent)
async def read_id(id_persona: int):
    for docent in db:
        if docent.id == id_persona:
            return docent
    raise HTTPException(status_code=404, detail=f"ID {id_persona} not found")


@app.put("/docents/{id_docent}", response_model=docent.Docent)
async def update_docent(id_docent: int, update_docent: docent.Docent):
    for index, docent in enumerate(db):
        if docent.id == id_docent:
            db[index] = update_docent
            return update_docent
    raise HTTPException(status_code=404, detail=f"ID {id_docent} not found")


@app.post("/docents/", response_model=docent.Docent)
async def create_persona(docent: docent.Docent):
    for docent in db:
        if docent.id == id_docent:
            raise HTTPException(status_code=406, detail=f"ID: {id_docent}, ja existeix")

    db.append(docent)
    return docent


@app.delete("/docents/{id_docent}", status_code=204)
async def delete_docent(id_docent: int):
    for index, docent in enumerate(db):
        if docent.id == id_docent:
            db.pop(index)
            return docent
    raise HTTPException(status_code=404, detail=f"ID {id_docent} not found")

using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallController : MonoBehaviour
{
    public Rigidbody rb;
    public float impulseForce = 5f;
    public GameObject splitPrefab;
    private Vector3 startPos;
    public int perfectPass = 0;
    private bool ignoreNextCollision;
    public bool isSuperSpeedActive;
    private List<GameObject> splits = new List<GameObject>();

    private void Awake()
    {
        startPos = transform.position;
    }

    private void OnCollisionEnter(Collision other)
    {
        if (ignoreNextCollision)
            return;
        if (isSuperSpeedActive)
        {
            if (!other.transform.GetComponent<Goal>())
            {
                Destroy(other.transform.parent.gameObject);
            }
        }
        else
        {
            DeathPart deathPart = other.transform.GetComponent<DeathPart>();
            if (deathPart)
            {
                deathPart.HittedDeathPart();
            }
        }

        rb.velocity = Vector3.zero;
        rb.AddForce(Vector3.up * impulseForce, ForceMode.Impulse);

        GameObject newSplit = Instantiate(splitPrefab, new Vector3(transform.position.x, other.transform.position.y + 0.36f, transform.position.z), transform.rotation);
        newSplit.transform.localScale = Vector3.one * Random.Range(0.8f, 1.2f);
        newSplit.transform.parent = other.transform;

        splits.Add(newSplit);

        ignoreNextCollision = true;
        Invoke("AllowCollision", .2f);

        perfectPass = 0;
        isSuperSpeedActive = false;
    }

    public void ClearSplits()
    {
        foreach (GameObject split in splits)
        {
            Destroy(split);
        }
        splits.Clear();
    }

    private void Update()
    {
        if (perfectPass >= 3 && !isSuperSpeedActive)
        {
            isSuperSpeedActive = true;
            rb.AddForce(Vector3.down * 10, ForceMode.Impulse);
        }
    }

    public void ResetBall()
    {
        transform.position = startPos;
        ClearSplits();
    }

    private void AllowCollision()
    {
        ignoreNextCollision = false;
    }

    public void SetSplitColor(Color color)
    {
        splitPrefab.GetComponent<Renderer>().sharedMaterial.color = color;
    }
}

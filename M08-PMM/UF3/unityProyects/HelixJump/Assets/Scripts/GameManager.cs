using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class GameManager : MonoBehaviour
{

    public static GameManager singleton;
    public int best;
    public int score;
    public int currentStage = 0;
    public static int passCheckRing;

    public static bool gameOver;
    public static bool levelWin;

    public GameObject GamePanel;
    public GameObject GameOverPanel;
    public GameObject levelWinPanel;

    public TextMeshProUGUI currentLevelText;
    public TextMeshProUGUI nextLevelText;
    public TextMeshProUGUI currentScoreText;
    public TextMeshProUGUI bestScoreText;

    public Slider ProgressBar;


    private void Awake()
    {
        if (singleton == null)
            singleton = this;
        else if (singleton != this)
            Destroy(gameObject);

        // Load the saved highscore
        best = PlayerPrefs.GetInt("Highscore");
        currentStage = PlayerPrefs.GetInt("currentStage", 1);
    }

    private void Start()
    {
        passCheckRing = 0;
    }

    public void Update()
    {
        if (!gameOver && !levelWin)
        {
            GamePanel.SetActive(true);
            GameOverPanel.SetActive(false);
            levelWinPanel.SetActive(false);
            bestScoreText.text = "Best: " + GameManager.singleton.best;
            currentScoreText.text = "Score: " + GameManager.singleton.score;
            if (currentStage <= FindObjectOfType<HelixController>().levelsCount)
            {
                currentLevelText.text = currentStage.ToString();
                nextLevelText.text = (currentStage + 1).ToString();
            }
            else
            {
                currentLevelText.text = currentStage.ToString();
                nextLevelText.text = currentStage.ToString();
            }
            int progress = passCheckRing * 100 / FindObjectOfType<HelixController>().levelsCount;
            ProgressBar.value = progress;
        }

        if (gameOver)
        {
            if (levelWin)
            {
                levelWinPanel.SetActive(false);
            }
            GamePanel.SetActive(false);
            GameOverPanel.SetActive(true);
            if (Input.GetMouseButtonDown(0))
            {
                PlayerPrefs.SetInt("CurrentLevelIndex", currentStage + 1);
                SceneManager.LoadScene(0);
                gameOver = false;
                singleton.score = 0;
                FindObjectOfType<BallController>().ResetBall();
                FindObjectOfType<HelixController>().LoadStage(0);
            }
        }

        if (levelWin)
        {
            if (gameOver)
            {
                levelWin = false;
                gameOver = true;
            }
            else
            {
                GamePanel.SetActive(false);
                levelWinPanel.SetActive(true);
                if (Input.GetMouseButtonDown(0))
                {
                    NextLevel();
                }
            }
        }
    }

    public void NextLevel()
    {
        currentStage++;
        levelWin = false;
        FindObjectOfType<BallController>().ResetBall();
        FindObjectOfType<HelixController>().LoadStage(currentStage);
        Debug.Log("Next Level");
        passCheckRing = 0;
    }

    public void WinLevel()
    {
        Debug.Log("Win Level");
        levelWin = true;
    }

    public void RestartLevel()
    {
        Debug.Log("Restarting Level");
        gameOver = true;
    }

    public void AddScore(int scoreToAdd)
    {
        score += scoreToAdd;

        if (score > best)
        {
            PlayerPrefs.SetInt("Highscore", score);
            best = score;
        }
    }


}

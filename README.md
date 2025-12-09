<<<<<<< HEAD

```markdown
# 🏋️‍♂️ GymDeck Web App – Full Specification Document

**Version:** Web App MVP  
**Owner:** Jetro da Costa (Wise Jotta)  
**Type:** Progressive Web App (PWA)  
**Goal:** Transform GymDeck from a mobile Android app into a responsive web application with social fitness, workout tracking, and deck planning capabilities.

---

## ✅ App Overview

### 🧠 Concept
GymDeck allows users to create, store, and complete workout routines in the form of **Decks** (exercise card sets). The app includes:
- Progress tracking
- Friend comparisons
- XP-based gamification
- Lightweight social features

### 🎯 Target Users
- Fitness enthusiasts
- Personal trainers
- Beginners structuring home workouts
- Friends challenging each other virtually

---

## 📊 Core Features

| Feature | Description |
|--------|-------------|
| **Deck Creation** | Users build decks by selecting a list of exercises, setting durations or reps per card. |
| **Workout Session Runner** | Presents each card one by one in a flow. Tracks time, skips, and completion. |
| **Rating System** | Users rate the difficulty of a session post-workout. |
| **Progress Tracker** | Tracks total workouts, best streaks, and XP score. |
| **Leaderboards (Top 3 Friends)** | Highlights top users among friends for each deck and overall progress. |
| **Saved Decks** | Users can view, edit, or delete previously created decks. |
| **Friend Comparison** | Shows top 3 friends’ records per deck (name, score, duration). |
| **Daily Activity Summary** | Displays current week's workout frequency and session history. |
| **Account Sync** | User authentication and workout data synced to cloud (Firebase/Auth0). |

---

## ⚙️ Tech Stack Recommendations

| Layer | Technology |
|-------|------------|
| **Frontend** | React.js with TailwindCSS |
| **Backend** | Node.js + Express.js **or** Firebase Cloud Functions |
| **Database** | Firebase Firestore **or** MongoDB Atlas |
| **Authentication** | Firebase Auth **or** Auth0 |
| **Hosting** | Vercel / Netlify / Firebase Hosting |
| **State Management** | Redux Toolkit **or** Zustand |
| **Charts (Future)** | Recharts / Chart.js |
| **Media Uploads** | Cloudinary for user avatars (optional) |

---

## 🔁 Use Case Coverage

Each use case defines flows, triggers, and “fail if” conditions to assist dev automation tools (e.g. Lovable.app):

1. **Create Deck**
2. **Edit/Delete Deck**
3. **Start Workout Session**
4. **Rate Session**
5. **View Weekly Activity**
6. **View Saved Decks**
7. **Friend Leaderboards**
8. **Authentication**
9. **Social Comparison (Optional)**
10. **Offline Sync (Optional)**
11. **Account Settings**

→ Full use case list available in `USE_CASES.md` (or see issue tracker for integration steps).

---

## 🧪 Previous Android App Features

This web app is inspired by the original Android implementation (Kotlin + Jetpack Compose):

- ✅ Exercise cards & decks
- ✅ Workout timer
- ✅ Ratings & stars
- ✅ Saved decks & history
- ✅ Firebase Auth & Firestore
- ✅ Room DB (offline support)
- ✅ Weekly activity strip

---

## 🛠 Setup Instructions (Mobile App)

> *(For reference only)*

1. Open project in Android Studio  
2. Add `google-services.json` in `/app`  
3. Run the app

---

## 📁 Project Structure (Android)

```

/app/src/main/java/com/gymdeck/
├── data/
├── model/
├── screens/
├── ui/
├── utils/
├── viewmodels/

```

---

## 🚀 Migration Plan to Web

- [ ] Port data models from Kotlin to TypeScript interfaces
- [ ] Map Jetpack navigation graph to React Router
- [ ] Move Room logic to Firebase/Firestore or MongoDB
- [ ] Rebuild deck state/session logic using Redux/Zustand
- [ ] Build responsive layouts with Tailwind CSS
- [ ] Create persistent Auth system with Firebase/Auth0

---

## 🧠 Author Notes

This is just for fun : )


>>>>>>>

---

**Made with 💪 by Wise Jotta (Jetro da Costa)**
```

Let me know if you want this split into multiple files (like `USE_CASES.md`, `API_REFERENCE.md`, `FEATURES.md`), or if you'd like a downloadable ZIP with everything pre-filled.

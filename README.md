# LVNG -X

Android starter project for **LVNG -X**, a red-glass gaming utility concept.

## Current status

This ZIP is a **buildable project foundation / UI starter**, not the complete promised feature set.
It currently contains:
- Kotlin + Jetpack Compose Android app
- LVNG -X dark navy / crimson visual foundation
- Home dashboard with clearly marked planned/integration-pending systems
- Basic project structure and a GitHub Actions Android build workflow

It does **not** yet implement Shizuku control, overlay services, macro touch injection,
FPS monitoring, backup/restore, or the Diagnostics Engine. Those need to be implemented
and tested against Android versions and device permissions. The UI intentionally does not
pretend those systems are already working.

## Build locally

1. Open this folder in Android Studio (Hedgehog or newer recommended).
2. Use JDK 17.
3. Let Gradle sync.
4. Run the `app` configuration on an Android device/emulator (min SDK 26).

## Build on GitHub

1. Create a GitHub repository.
2. Upload/extract the contents of this ZIP into the repository root.
3. Push to the default branch.
4. GitHub Actions runs `.github/workflows/android-build.yml`.
5. Download the generated `LVNG-X-debug-apk` artifact from the workflow run.

## Package

`com.lvngx.app`

## Roadmap

### Foundation
- App shell, design system, navigation architecture
- Permission state model and capability gating
- Device / Android compatibility checks

### Core systems
- Shizuku Access Center (official Shizuku API; no silent service start)
- Overlay engine and lifecycle recovery
- Accessibility-backed macro engine with emergency stop and explicit permission checks
- Game library and profiles

### Intelligence and tools
- Performance telemetry only where Android exposes valid readings
- Session tools and game utilities
- Profile Backup & Restore using `.lvngx`, integrity checks and rollback
- Diagnostics Center with actionable, evidence-based results

## Important implementation rules

- Android permission grants and Shizuku sessions are never included in backups.
- Features requiring Shizuku, Accessibility, overlay, or MediaProjection must be gated independently.
- Unsupported capabilities must be shown as unavailable, not as fake toggles or fabricated metrics.
- Macro execution must stop on release, permission loss, service stop, screen lock, and lifecycle interruption.

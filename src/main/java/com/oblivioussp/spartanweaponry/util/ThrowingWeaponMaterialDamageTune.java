package com.oblivioussp.spartanweaponry.util;

import com.oblivioussp.spartanweaponry.api.WeaponMaterial;

public final class ThrowingWeaponMaterialDamageTune
{
	private ThrowingWeaponMaterialDamageTune()
	{
	}

	public record VanillaMetalThrowingDamageTiers(float ironDirectAttackDamage, float goldDirectAttackDamage,
			float diamondDirectAttackDamage, float netheriteDirectAttackDamage)
	{
		public float desiredDirectAttackDamageForMaterialOrLegacyFormula(WeaponMaterial material,
				float archetypeBaseWeaponDamageConstantFromConfigOrDefaults,
				float archetypeDamageMultiplier)
		{
			return switch (material.getMaterialName())
			{
				case "iron" -> ironDirectAttackDamage;
				case "gold" -> goldDirectAttackDamage;
				case "diamond" -> diamondDirectAttackDamage;
				case "netherite" -> netheriteDirectAttackDamage;
				default -> material.getAttackDamageBonus() * archetypeDamageMultiplier
						+ archetypeBaseWeaponDamageConstantFromConfigOrDefaults - 1.0f;
			};
		}
	}

	public static float baseWeaponDamageConstantMatchingDesiredDirectAttackDamage(
			VanillaMetalThrowingDamageTiers tiers, WeaponMaterial material,
			float archetypeBaseWeaponDamageConstantFromConfigOrDefaults, float archetypeDamageMultiplier)
	{
		float desiredDirect = tiers.desiredDirectAttackDamageForMaterialOrLegacyFormula(material,
				archetypeBaseWeaponDamageConstantFromConfigOrDefaults, archetypeDamageMultiplier);
		return desiredDirect + 1.0f - material.getAttackDamageBonus() * archetypeDamageMultiplier;
	}
}
